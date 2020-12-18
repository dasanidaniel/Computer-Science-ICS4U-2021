// team.model.js

const mongoose = require('mongoose');
const Schema = mongoose.Schema;

// Define collection and schema for Post
let Team = new Schema({
  name: {
    type: String
  },
  win: {
    type: Number, default: 0
  },
  loss: {
      type: Number, default: 0
  },
 
  GB: {
    type: Number, default: 0
  },
  
  divRecord: {
    win: {type:Number, default: 0},
    loss: {type:Number, default: 0}
  },
  confRecord: {
    win: {type:Number, default: 0},
    loss: {type:Number, default: 0}
  },
  numGames: {
    type:Number, default: 0
  },
  PPG: {
    type:Number, default: 0
  },
  oppPPG: {
    type: Number, default:0
  },
  avgDiff: {
    type:Number, default: 0
  },

  conference: {
    type: String, default: "East"
  }

},{
    collection: 'teams'
});

module.exports = mongoose.model('Team', Team);