const express = require('express');
const gameRoutes = express.Router();

// Require Post model in our routes module
let Game = require('./game.model');
let Team = require('./team.model');
// const { route } = require('./team.route');



// updates conference record - pass in wining, losing team and response
function updateConf(win, loss) {
  win.confRecord.win += 1;
  loss.confRecord.loss += 1;
  
}
function undoTeamUpdate(game, res) {
  let winner;
  let loser;
  let winScore;
  let lossScore;
  let loserID;
  let winnerID;
  let winnerFound = false;
  let loserFound = false;
 
  if (parseInt(game.awayScore,10) > parseInt(game.homeScore,10)) {
    winner = game.awayTeam;
    loser = game.homeTeam;
    winScore = parseInt(game.awayScore, 10);
    lossScore = parseInt(game.homeScore, 10);
  } else {
    winner = game.homeTeam;
    loser = game.awayTeam;
    lossScore = parseInt(game.awayScore, 10);
    winScore = parseInt(game.homeScore,10);
  }

  Team.find((err, teams) => {
    if (err) {
      console.log(err);
      res.json(err);
    } else {
      teams.forEach(team => { 
        if (team.name === winner) {
          winnerID = team._id;
          team.win -= 1;
          team.numGames -= 1;
          team.PPG -= winScore;
          team.oppPPG -= lossScore;
          team.avgDiff -= (winScore - lossScore);
          winner = team;
          winnerFound = true;
        } else if (team.name === loser) {
          loserID = team._id;
          team.loss -= 1;
          team.numGames -= 1;
          team.PPG -= lossScore;
          team.oppPPG -= winScore;
          team.avgDiff -= (lossScore - winScore);
          loser = team;  
          loserFound = true;
        };
      });
      // removes incorrect statistics of conference losing team and winning team
      if (!winnerFound || !loserFound) {
        console.log("no team found");
      } else {
      if (loser.conference === winner.conference) {
        undoUpdateConf(winner, loser, res);
      }
    

      teams.forEach(team => {    
        if (team._id.toString() === loserID.toString()) {
          team = new Team(loser);  
          console.log(team);
          team.save().catch(err => res.json(err));
          
        } else if (team._id.toString() === winnerID.toString()) {
          team = new Team(winner);
          console.log(team);
          team.save().catch(err => res.json(err));
        }
      })
    } 
      console.log("Undo Teams updated");

    }
  })
}
function undoUpdateConf(winner, loser) {
  winner.confRecord.win -= 1;
  loser.confRecord.loss -= 1;
}
// updates teams collection
function getData(game, res) {
  let winner;
  let loser;
  let winScore;
  let lossScore;
  let winnerID;
  let loserID;

  // determines winning and losing team
  if (parseInt(game.awayScore, 10) > parseInt(game.homeScore, 10)) {
    winner = game.awayTeam;
    loser = game.homeTeam;
    winScore = parseInt(game.awayScore,10);
    lossScore = parseInt(game.homeScore,10);
  } else {
    winner = game.homeTeam;
    loser = game.awayTeam;
    lossScore = parseInt(game.awayScore,10);
    winScore = parseInt(game.homeScore,10);
    
  }
 

  // updates teams in teams collection
  Team.find((err, teams) => {
    if (err) {
      res.json(err);
    } else {
      teams.forEach(team => {
        if (team.name === winner) {
          team.win += 1;
          team.numGames += 1;
          team.PPG += winScore;
          team.oppPPG += lossScore;
          team.avgDiff += winScore - lossScore;
          
          winnerID = team._id;
          winner = team;
  
        } else if (team.name === loser) {
          team.loss += 1;
          team.numGames += 1;
          team.PPG += lossScore;
          team.oppPPG += winScore;
          team.avgDiff += lossScore - winScore;
         
          loserID = team._id;
          loser = team;
 
        };
      });
      
      if (winner.conference === loser.conference) {
        updateConf(winner, loser, res);
      }
     
    }
    teams.forEach(team => {           
      if (team._id.toString() === loserID.toString()) {
        team = new Team(loser);
        console.log("Losing Team: " + loser)
        team.save().catch(err => res.json(err));
      } else if (team._id.toString() === winnerID.toString()) {
        team = new Team(winner);
        console.log("Winning Team: " + winner);
        team.save().catch(err => res.json(err));
      }
    });
  });
  
  console.log("Teams updated");

}
// Adds a game to game collection - updates teams collection as well
gameRoutes.route('/add').post(function (req, res) {
  let game = new Game(req.body);
  
  console.log(game);
  getData(game, res);
  game.save()
    .then(() => {
      
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
      
      res.json(games);
    }
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

// removes stats associated with that specific game for team
// used in both update and delete paths


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
      getData(game, res);
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
  Game.findById(req.params.id, function (err, game) {
    if (err) {
      res.json(err);
    }
    if (!game)
      res.status(404).send("data is not found");
    else {
      undoTeamUpdate(game, res);
    }

  });
  Game.findByIdAndRemove({ _id: req.params.id }, function (err) {
    if (err) res.json(err);
    else res.json('Successfully removed');
  });
});



module.exports = gameRoutes;