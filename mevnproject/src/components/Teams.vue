 <template>
 <div >
   <div >
     <div >
       <div >Stats</div>

       <div >
         This is where a table with overall statistics will be placed.       </div>
     <div>
         <table class="table table-hover">
            <thead>
            <tr>
              <th>Name</th>
              <th>W</th>
              <th>L</th>
              <th>W/L</th>
              <th>GB</th>
              <th>HOME</th>
              <th>AWAY</th>
              <th>DIV</th>
              <th>CONF</th>
              <th>PPG</th>
              <th>OPP PPG</th>
              <th>DIFF</th>
              <th>STRK</th>
              <th>L10</th>

            </tr>
            </thead>
            <tbody>
               <!-- <tr v-for="team in teams" :key="post._id">
                  <td>{{ post.title }}</td>
                  <td>{{ post.body }}</td>
                  <td>{{ post.author }}</td>
                  <td><router-link :to="{name: 'edit', params: { id: post._id }}" class="btn btn-primary">Edit</router-link></td>
                  <td><button v-on:click= deletePost(post._id) class="btn btn-danger">Delete</button>
                  
                  </td>
        -->
            </tbody>
         </table>          
        </div>
     </div>
   </div>
 </div>
 </template>
 <script>
export default {};
</script>