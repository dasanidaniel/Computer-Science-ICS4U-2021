const express = require('express');
const gameRoutes = express.Router();

// Require Post model in our routes module
let Game = require('./game.model');
let Team = require('./team.model');
// const { route } = require('./team.route');

function getData(req, res) {
  let winner;
  let loser;
  let winScore;
  let lossScore;
  if (req.awayScore > req.homeScore) {
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
      console.log(err);
      res.json(err);
    } else {
      console.log(winner);
      teams.forEach(team => {
        console.log(team.name);
        if (team.name === winner) {
          
          team.win += 1;
          team.numGames += 1;
          team.PPG += winScore;
          team.oppPPG += lossScore;
          
          team.save()
          .then(() => {
            console.log("Win Update Complete");
          }).catch(() => {
            res.status(400).send("unable to update the database");
          });
        } else if (team.name === loser) {
          console.log("Lbefore : " + team);
          team.loss += 1;
          team.numGames += 1;
          team.PPG += Integer.parseInt(lossScore);
          team.oppPPG += Integer.parseInt(winScore);
          console.log("Lafter : " + team);
          team.save().then(() => {
            console.log("Loss Update Complete");
          }).catch(() => {
            res.status(400).send("unable to update the database");
          });
        };
      });

      console.log("Teams updated");
  
    }
  });
}
// Defined store route
gameRoutes.route('/add').post(function (req, res) {
  console.log(req.body);
  let game = new Game(req.body);
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
      games.sort((a, b) => a.date > b.date ? 1 : -1);
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


//  Defined update route
gameRoutes.route('/update/:id').post(function (req, res) {
  Game.findById(req.params.id, function (err, game) {
    if (!game)
      res.status(404).send("data is not found");
    else {
      console.log(req.body);
      game.date = req.body.date;
      game.homeTeam = req.body.homeTeam;
      game.homeScore = req.body.homeScore;
      game.awayTeam = req.body.awayTeam;
      game.awayScore = req.body.awayScore;
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