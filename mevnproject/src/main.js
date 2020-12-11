// main.js

import Vue from 'vue'
import App from './App.vue'
import 'bootstrap/dist/css/bootstrap.min.css'

import VueRouter from 'vue-router';
Vue.use(VueRouter);

import VueAxios from 'vue-axios';
import axios from 'axios';

Vue.use(VueAxios, axios);

Vue.config.productionTip = false

import NewGame from './components/NewGame.vue';
import NewTeam from './components/NewTeam.vue';
import Teams from './components/Teams.vue';
import UpdateTeam from './components/UpdateTeam.vue';
import TeamBreakdown from './components/TeamBreakdown.vue';
import HomeComponent from './components/HomeComponent.vue';
import Games from './components/Games.vue';

const routes = [
  {
    name: 'Home',
    path: '/',
    component: HomeComponent
  },
  {
      name: 'teams',
      path: '/teams',
      component: Teams
  },
  {
      name: 'newTeam',
      path: '/newTeam',
      component: NewTeam
  },
  {
      name: 'editTeam',
      path: '/editTeam/:id',
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
  },
  {
    name: 'gamePage',
    path: '/games',
    component: Games
  }
];

const router = new VueRouter({ mode: 'history', routes: routes});

new Vue(Vue.util.extend({ router }, App)).$mount('#app');