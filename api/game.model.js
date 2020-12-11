// game.model.js

const mongoose = require('mongoose');
const Schema = mongoose.Schema;

// Define collection and schema for Game
let Game = new Schema({
  date: {
    type: String
  },
  teamOne: {
    type: String, default: "empty"
  },
  teamOneScore: {
      type: Number, default: 0
  },
  teamTwo: {
      type: String, default: "empty"
  },
  teamTwoScore: {
      type: Number, default: 0
  }

},{
    collection: 'games'
});

module.exports = mongoose.model('Game', Game);