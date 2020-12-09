// team.model.js

const mongoose = require('mongoose');
const Schema = mongoose.Schema;

// Define collection and schema for Post
let Team = new Schema({
  title: {
    type: String
  },
  win: {
    type: Number
  },
  loss: {
      type: Number
  },
  PCT: {
    type: Number
  },
  GB: {
    type: Number
  },
  home: {
    win: {Number},
    loss: {Number},
  },
  away: {
    win: {type:Number},
    loss: {type:Number}
  },
  divRecord: {
    win: {type:Number},
    loss: {type:Number}
  },
  confRecord: {
    win: {type:Number},
    loss: {type:Number}
  },
  PPG: {
    type:Number
  },
  avgDiff: {
    type:Number
  },
  streak: {
      type: String
  },
  last10: {
      win: {type: Number},
      loss: {type: Number}
  }

},{
    collection: 'teams'
});

module.exports = mongoose.model('Team', Team);