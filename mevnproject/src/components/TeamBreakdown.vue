 <template>
  <div class = "container-fluid">
    <div>
      <div>
        
        <div class="row mb-5">
          <div class = "col">
          <h3 class= "text-center">EASTERN CONFERENCE</h3>
          <table class="table table-hover">
            <thead class="thead-dark">
              <tr>
                <th>Name</th>
                <th>W</th>
                <th>L</th>
                <th>W/L</th>
                <th>GB</th>
               
                <th>CONF</th>
                <th>PPG</th>
                <th>OPP PPG</th>
                <th>DIFF</th>

              
                <th>EDIT</th>
                <th>DELETE</th>
              </tr>
            </thead>

            <tbody class="bg-light">
              <tr v-for="team in eTeams" :key="team._id">
                <td>{{ team.name }}</td>
                <td>{{ team.win }}</td>
                <td>{{ team.loss }}</td>
                <td>{{ team.PCT }}</td>
                <td>{{ team.GB }}</td>
              
                <td>{{ team.confRecord.win }}-{{ team.confRecord.loss }}</td>
                <td>{{ team.PPG / team.numGames }}</td>
                <td>{{ team.oppPPG / team.numGames}}</td>
                <td>{{ team.avgDiff }}</td>
           

                <td>
                  <router-link
                    :to="{ name: 'editTeam', params: { id: team._id } }"
                    class="btn btn-primary"
                    >Edit</router-link
                  >
                </td>
                <td>
                  <button
                    v-on:click="deleteTeam(team._id)"
                    class="btn btn-danger"
                  >
                    Delete
                  </button>
                </td>
              </tr>
              
            </tbody>
          </table>
          </div></div>
           <div class="row form-group">
          <div class = "col">
          <h3 class= "text-center">WESTERN CONFERENCE</h3>
          <table class="table table-hover">
            <thead class="thead-dark">
              <tr>
                <th>Name</th>
                <th>W</th>
                <th>L</th>
                <th>W/L</th>
                <th>GB</th>
               
                <th>CONF</th>
                <th>PPG</th>
                <th>OPP PPG</th>
                <th>DIFF</th>

              
                <th>EDIT</th>
                <th>DELETE</th>
              </tr>
            </thead>

            <tbody class="bg-light">
              <tr v-for="team in wTeams" :key="team._id">
                <td>{{ team.name }}</td>
                <td>{{ team.win }}</td>
                <td>{{ team.loss }}</td>
                <td>{{ team.PCT }}</td>
                <td>{{ team.GB }}</td>
              
                <td>{{ team.confRecord.win }}-{{ team.confRecord.loss }}</td>
                <td>{{ team.PPG / team.numGames}}</td>
                <td>{{ team.oppPPG / team.numGames}}</td>
                <td>{{ team.avgDiff }}</td>
           

                <td>
                  <router-link
                    :to="{ name: 'editTeam', params: { id: team._id } }"
                    class="btn btn-primary"
                    >Edit</router-link
                  >
                </td>
                <td>
                  <button
                    v-on:click="deleteTeam(team._id)"
                    class="btn btn-danger"
                  >
                    Delete
                  </button>
                </td>
              </tr>
              
            </tbody>
          </table>
          </div></div>
      </div>
    </div>
  </div>
</template>
 <script>
export default {
  data() {
    return {
      eTeams: [],
      wTeams: []
    };
  },
 
  methods: {
    deleteTeam(id) {
      let uri = `//localhost:5000/teams/delete/${id}`;
      this.axios.delete(uri).then((response) => {
        this.teams = this.teams.filter((r) => r._id != id);
        console.log(response.data);
      });
    },
  },
  created() {
    let uri = "http://localhost:5000/teams/teams";
    this.axios.get(uri).then((response) => {
      this.eTeams = response.data.filter((team) => team.conference === 'East');
      this.wTeams = response.data.filter((team) => team.conference === 'West');
    });
  },
};
</script>