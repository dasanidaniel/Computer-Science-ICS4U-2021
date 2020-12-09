<template>
 
 <div >
  <nav >
   <ul class="nav nav-pills nav-fill">
    <li class="nav-item">
     <router-link class="nav-link" to="/" >Home</router-link>
    </li>
    <li class="nav-item">
     <router-link class="nav-link" to="/newTeam" >Add Team</router-link>
    </li>
    <li class="nav-item">
     <router-link class="nav-link" to="/newGame" >Add Game</router-link>
    </li>
    <li class="nav-item">
     <router-link class="nav-link" to="/teamBreakdown" >Team Breakdown</router-link>
    </li>
   </ul>
  </nav><br />
  <transition name=fade>
   <router-view></router-view>
  </transition>
 </div>
</template>

<script>


export default {
  name: 'app'
}
</script>

<style>

</style>
