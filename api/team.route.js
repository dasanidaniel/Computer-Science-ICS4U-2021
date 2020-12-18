const express = require('express');
const teamRoutes = express.Router();

// Require Post model in our routes module
let Team = require('./team.model');
let Game = require('./game.model');

function updateGame(old, name, res) {
  Game.find((err, games) => {
    if (err) {
      console.log("The error is: " + err);
      res.json(err);
    } else {
      
      games.forEach((game) => {
        
        if (game.homeTeam === old) {
          
          game.homeTeam = name;
          game.save()
          .catch(() => {
            res.status(400).send("unable to save to database");
          });

        } else if (game.awayTeam === old) {
          game.awayTeam = name;
          game.save()
          .catch(() => {
            res.status(400).send("unable to save to database");
          });
          console.log('game Updated');
        } else {
          console.log('no team found');
        }
      });
     
    }
});
}

// Defined store route
teamRoutes.route('/add').post(function (req, res) {
  let team = new Team(req.body);
  team.save()
    .then(() => {
      res.status(200).json({'team': 'team added successfully'});
    })
    .catch(() => {
      res.status(400).send("unable to save to database");
    });
});

// Defined get data(index or listing) route
teamRoutes.route('/teams').get(function (req, res) {
    Team.find(function(err, teams){
    if(err){
      res.json(err);
    }
    else {
      res.json(teams);
    }
  });
});

// Defined edit route
teamRoutes.route('/editTeam/:id').get(function (req, res) {
  let id = req.params.id;
  Team.findById(id, function (err, team){
      if(err) {
        res.json(err);
      }
      res.json(team);
  });
});

//  Defined update route
teamRoutes.route('/updateTeam/:id').post(function (req, res) {
    Team.findById(req.params.id, function(err, team) {
    let old = team.name;
  
    if (!team)
      res.status(404).send("data is not found");
    else {
        team.name = req.body.name;
        updateGame(old, team.name, res);
        team.save().then(() => {
          res.json('Update complete');
      })
      .catch(() => {
            res.status(400).send("unable to update the database");
      });
    }
  });
});

// Defined delete | remove | destroy route
teamRoutes.route('/delete/:id').delete(function (req, res) {
    Team.findByIdAndRemove({_id: req.params.id}, function(err){
        if(err) res.json(err);
        else res.json('Successfully removed');
    });
});

module.exports = teamRoutes;