// main.js

import Vue from 'vue'
import App from './App.vue'
import 'bootstrap/dist/css/bootstrap.min.css'

import VueRouter from 'vue-router';
Vue.use(VueRouter);

Vue.config.productionTip = false

import NewGame from './components/NewGame.vue';
import NewTeam from './components/NewTeam.vue';
import Stats from './components/Stats.vue';
import UpdateTeam from './components/UpdateTeam.vue';
import TeamBreakdown from './components/TeamBreakdown.vue';

const routes = [
  {
      name: 'Stats',
      path: '/',
      component: Stats
  },
  {
      name: 'newTeam',
      path: '/newTeam',
      component: NewTeam
  },
  {
      name: 'editTeam',
      path: '/edit/:id',
      component: UpdateTeam
  },
  {
      name: 'newGame',
      path: '/newGame',
      component: NewGame
  },
  {
    name:'teamBreakdown',
    path: '/teamBreakdown',
    component: TeamBreakdown
  }
];

const router = new VueRouter({ mode: 'history', routes: routes});

new Vue(Vue.util.extend({ router }, App)).$mount('#app');