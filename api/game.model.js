// game.model.js

const mongoose = require('mongoose');
const Schema = mongoose.Schema;

// Define collection and schema for Game
let Game = new Schema({
  date: {
    type: Date, String
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