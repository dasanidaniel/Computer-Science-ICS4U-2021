<template>
  <div>
    

    <div class="container-fluid">
      <div class="row">
        <img
          src="./images/nbaLogo.jpg"
          width="200px"
          height="100px"
          class="rounded mx-auto d-block"
          alt="NBA Logo"
        />
      </div>
      <div class="container-fluid">
        <nav>
          <ul class="nav nav-pills nav-fill navbar-expand-lg navbar-light bg-light">
            <li class="nav-item">
              <router-link class="nav-link" to="/">Home</router-link>
            </li>
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
              <router-link class="nav-link" to="/teamBreakdown"
                >Team Breakdown</router-link
              >
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

.router-link-exact-active{
  background: grey;
  color: white;
}
.error-message {
  color: red;
}
</style>
