const express = require('express');
const gameRoutes = express.Router();

// Require Post model in our routes module
let Game = require('./game.model');
let Team = require('./team.model');
// const { route } = require('./team.route');
function updateConf(win, loss, res) {
  win.confRecord.win += 1;
  loss.confRecord.loss += 1;
  win.save().catch(() => {
    res.status(400).send("unable to update the database");
  });
  loss.save().catch(() => {
    res.status(400).send("unable to update the database");
  });
}

function undoUpdateConf(win, loss, res) {
  win.confRecord.win -= 1;
  loss.confRecord.loss -= 1;
  win.save().catch(() => {
    res.status(400).send("unable to update the database");
  });
  loss.save().catch(() => {
    res.status(400).send("unable to update the database");
  });
}

function getData(req, res) {
  let winner;
  let loser;
  let winScore;
  let lossScore;
  
  
  if (req.body.awayScore > req.body.homeScore) {
    winner = req.body.awayTeam;
    loser = req.body.homeTeam;
    winScore = req.body.awayScore;
    lossScore = req.body.homeScore;
  } else {
    winner = req.body.homeTeam;
    loser = req.body.awayTeam;
    lossScore = req.body.awayScore;
    winScore = req.body.homeScore;
  }
  Team.find((err, teams) => {
    if (err) {
      console.log("The error is: " + err);
      res.json(err);
    } else {
      
      teams.forEach(team => {
     
        if (team.name === winner) {
          
          team.win += 1;
          team.numGames += 1;
          team.PPG = parseInt(team.PPG, 10) + parseInt(winScore, 10);
          team.oppPPG = parseInt(team.oppPPG, 10) + parseInt(lossScore, 10);
          team.avgDiff += (team.PPG - team.oppPPG) / team.numGames;
          console.log("Winning Team: " + team);
          winner = team;
          team.save().catch(() => {
            res.status(400).send("unable to update the database");
          });
        } else if (team.name === loser) {
          
          team.loss += 1;
          team.numGames += 1;
          team.PPG = parseInt(team.PPG, 10) + parseInt(winScore, 10);
          team.oppPPG = parseInt(team.oppPPG, 10) + parseInt(lossScore, 10);
          team.avgDiff += (team.PPG - team.oppPPG) / team.numGames;
          console.log("Losing Team : " + team);
          loser = team;
          team.save().catch(() => {
            res.status(400).send("unable to update the database");
          });
        };
      });
      if (winner.conference === loser.conference) {
        updateConf(winner, loser, res);
      }
      console.log("Teams updated");
      
    }
  });
}
// Defined store route
gameRoutes.route('/add').post(function (req, res) {
  let game = new Game(req.body);
  game.homeScore = parseInt(game.homeScore.toFixed(0));
  game.awayScore = parseInt(game.awayScore.toFixed(0));
  console.log(game);
  game.save()
    .then(() => {
      getData(req, res);
      res.status(200).json({ 'game': 'game added successfully' });
    })
    .catch(() => {
      res.status(400).send("unable to save to database");
    });

   
});

// Defined get data(index or listing) route
gameRoutes.route('/games').get(function (req, res) {
  Game.find(function (err, games) {
    if (err) {
      res.json(err);
    }
    else {
      games.sort((a, b) => a.date < b.date ? 1 : -1);
      res.json(games);    }
  });
});

// Defined edit route
gameRoutes.route('/edit/:id').get(function (req, res) {
  let id = req.params.id;
  Game.findById(id, function (err, game) {
    if (err) {
      res.json(err);
    }
    res.json(game);
  });
});

function undoTeamUpdate(game, res) {
  let winner;
  let loser;
  let winScore;
  let lossScore;
  if (game.awayScore > game.homeScore) {
    winner = game.awayTeam;
    loser = game.homeTeam;
    winScore = game.awayScore;
    lossScore = game.homeScore;
  } else {
    winner = game.homeTeam;
    loser = game.awayTeam;
    lossScore = game.awayScore;
    winScore = game.homeScore;
  }
  Team.find((err, teams) => {
    
    if (err) {
      console.log(err);
      res.json(err);
    } else {
      
      teams.forEach(team => {
        console.log(team.name);
        if (team.name === winner) {
          
          team.win -= 1;
          team.numGames -= 1;
          team.PPG -= winScore;
          team.oppPPG -= lossScore;
          console.log("Undo Team: " + team);
          team.save().catch(() => {
            res.status(400).send("unable to update the database");
          });
          winner = team;
        } else if (team.name === loser) {
          team.loss -= 1;
          team.numGames -= 1;
          team.PPG -= parseInt(lossScore);
          team.oppPPG -= parseInt(winScore);
          console.log("Undo L Team : " + team);
          team.save().catch(() => {
            res.status(400).send("unable to update the database");
          });
          loser = team;
        };
      });
      // removes incorrect statistics of conference losing team and winning team
      if (loser.conference === winner.conference) {
        undoUpdateConf(winner, loser, res);
      }

      console.log("Undo Teams updated");
  
    }
})
}

//  Defined update route
gameRoutes.route('/update/:id').post(function (req, res) {
  Game.findById(req.params.id, function (err, game) {
    if (!game)
      res.status(404).send("data is not found");
    else {
     
      undoTeamUpdate(game, res);
      game.date = req.body.date;
      game.homeTeam = req.body.homeTeam;
      game.homeScore = req.body.homeScore;
      game.awayTeam = req.body.awayTeam;
      game.awayScore = req.body.awayScore;
      getData(req, res);
      game.save().then(() => {
        res.json('Update complete');
      })
        .catch(() => {
          res.status(400).send("unable to update the database");
        });
    }

  });
});

// Defined delete | remove | destroy route
gameRoutes.route('/delete/:id').delete(function (req, res) {
  Game.findByIdAndRemove({ _id: req.params.id }, function (err) {
    if (err) res.json(err);
    else res.json('Successfully removed');
  });
});



module.exports = gameRoutes;