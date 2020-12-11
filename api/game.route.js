const express = require('express');
const gameRoutes = express.Router();

// Require Post model in our routes module
let Game = require('./game.model');

// Defined store route
gameRoutes.route('/add').post(function (req, res) {
  let Game = new Game(req.body);
  game.save()
    .then(() => {
      res.status(200).json({'game': 'game added successfully'});
    })
    .catch(() => {
      res.status(400).send("unable to save to database");
    });
});

// Defined get data(index or listing) route
gameRoutes.route('/games').get(function (req, res) {
    Game.find(function(err, games){
    if(err){
      res.json(err);
    }
    else {
      res.json(games);
    }
  });
});

// Defined edit route
gameRoutes.route('/edit/:id').get(function (req, res) {
  let id = req.params.id;
  Game.findById(id, function (err, game){
      if(err) {
        res.json(err);
      }
      res.json(game);
  });
});

//  Defined update route
gameRoutes.route('/update/:id').post(function (req, res) {
    Game.findById(req.params.id, function(err, game) {
    if (!game)
      res.status(404).send("data is not found");
    else {
        game.name = req.body.name;
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
    Game.findByIdAndRemove({_id: req.params.id}, function(err){
        if(err) res.json(err);
        else res.json('Successfully removed');
    });
});

module.exports = gameRoutes;