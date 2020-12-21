// game.model.js

const mongoose = require('mongoose');
const Schema = mongoose.Schema;
// const Team = require('./team.model');

// Define collection and schema for Game
let Game = new Schema({
  date: {
    type: Date, default: new Date()
  },
  homeTeam: {
    type: String, default: "empty"
  },
  homeScore: {
      type: Number, default: 0
  },
  awayTeam: {
      type: String, default: "empty"
  },
  awayScore: {
      type: Number, default: 0
  }

},{
    collection: 'games'
});

module.exports = mongoose.model('Game', Game);