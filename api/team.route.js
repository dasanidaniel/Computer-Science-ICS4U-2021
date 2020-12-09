const express = require('express');
const teamRoutes = express.Router();

// Require Post model in our routes module
let Team = require('./post.model');

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
postRoutes.route('/').get(function (req, res) {
    Team.find(function(err, posts){
    if(err){
      res.json(err);
    }
    else {
      res.json(posts);
    }
  });
});

// Defined edit route
teamRoutes.route('/edit/:id').get(function (req, res) {
  let id = req.params.id;
  Team.findById(id, function (err, post){
      if(err) {
        res.json(err);
      }
      res.json(post);
  });
});

//  Defined update route
teamRoutes.route('/update/:id').post(function (req, res) {
    Team.findById(req.params.id, function(err, post) {
    if (!post)
      res.status(404).send("data is not found");
    else {
        team.title = req.body.title;
        team.body = req.body.body;
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

module.exports = postRoutes;