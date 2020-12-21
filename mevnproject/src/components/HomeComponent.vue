 <template>
 <div class="container-fluid">
   <div >
     <div >
       <div class="text-center">
         <h1>Welcome</h1></div>

       <div class="container">
         <p>This is an app that tracks, team games and update teams' statistics on a general Roster <br>
           Within this app you are able to add teams and games.<br>
           There are form submission control to ensure that all input is valid before submitting to database.<br>
           When editing a game or a team, information is linked so that game and team information is synchronized<br>
           (e.g.) Changing a team's name will change the team's name in the games that they have been recorded playing<br>
           (e.g.) Changing a game's score and winner will change the team's statistics in the teams collection<br>
           The Team Breakdown page sorts the teams by number of wins in their conference as well as what conference they are in (East or West)<br>
           <br>
          
         </p>
         <h5>Future Changes</h5>
           <p>In future, I would change the update, add, and delete paths for both team and game collections to instead of updating DB by every entry/action (add, delete, update), I would go through the games collection and update teams accordingly each time.
           <br>(e.g.) adding or updating a game would trigger a method that would go through each game in the collection and reconfigure the stats of each team.
           
           <br>I would also fix the CSS.
           <br>
           <br>- Ryan Hui
         </p>
         <h3>Enjoy!</h3>
       </div>
     </div>
   </div>
 </div>
 </template>
 <script>
 export default {
 }
 </script>