<template>
  <div>
    <div class="container-fluid">
      <div class="row">
        <a href="/">
        <img
          src="./images/nbaLogo.jpg"
          to="/"
          width="200px"
          height="100px"
          class="rounded mx-auto d-block"
          alt="NBA Logo"
        />
        </a>
      </div>
      
      <div class="container-fluid">
        <nav>
          <ul class="nav nav-pills nav-fill navbar-expand-lg navbar-light bg-light">
            <li class="nav-item">
              <router-link class="nav-link" to="/teams">Teams</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/games">Games</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/newTeam">Add Team</router-link>
            </li>
            <li class="nav-item ">
              <router-link class="nav-link" to="/newGame">Add Game</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/teamBreakdown">Team Breakdown</router-link>
            </li>
          </ul>
        </nav>
        <br />
      </div>
    </div>
    <transition name="fade">
      <router-view></router-view>
    </transition>
  </div>
</template>

<script>
export default {
  name: "app",
};
</script>

<style>
html, 
body {
    margin: 0;
    padding: 0;
    background-color:rgb(0, 0, 0);
}

.row{
  background: rgb(0, 0, 0);
}

.container-fluid{
  background: rgb(0, 0, 0);
}

.nav-link{
  color: white;
}

.nav-link:hover{
  color: rgb(255, 0, 0);
}

.nav-item{
  background: rgb(41, 41, 41);
  color: rgb(255, 255, 255);
}

.router-link-exact-active{
  background: rgb(255, 255, 255);
  color: rgb(0, 0, 0);
}

.error-message {
  color: red;
}

img {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 13%;
}
</style>
