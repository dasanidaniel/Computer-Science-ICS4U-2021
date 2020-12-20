 <template>
  <div>
    <div>
      <div>
       
        <div class="container-fluid">
          <h3 class="text-center">NBA Teams Roster</h3>
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
              <tr v-for="team in teams" :key="team._id">
                <td>{{ team.name }}</td>
                <td>{{ team.win }}</td>
                <td>{{ team.loss }}</td>
                <td>{{ calculate(team.win / team.loss) }}</td>
                <td>{{ team.GB }}</td>

                <td>{{ team.confRecord.win }}-{{ team.confRecord.loss }}</td>
                <td>{{ calculate(team.PPG / team.numGames)}}</td>
                <td>{{ calculate(team.oppPPG / team.numGames) }}</td>
                <td>{{ calculate(team.avgDiff / team.numGames) }}</td>
           

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
              <tr>
                <td> </td>
                <td> </td>
                <td> </td>
                <td> </td>
                <td> </td>
                <td> </td>
                <td> </td>
                <td> </td>
                <td> </td>
               

                <td>
                  <router-link
                    :to="{ name: 'newTeam'}"
                    class="btn btn-primary"
                    >+ Team</router-link
                  >
                </td>
                <td></td>
                
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>
 <script>
export default {
  data() {
    return {
      teams: [],
    };
  },
 
  methods: {
    calculate(number) {
      return number.toFixed(1);
    },
    deleteTeam(id) {
      let uri = `//localhost:5000/teams/delete/${id}`;
      this.axios.delete(uri).then((response) => {
        this.teams = this.teams.filter((r) => r._id != id);
        console.log(response.data);
      });
    },
  },
  created() {
    console.log("Teams page");
    let uri = "http://localhost:5000/teams/teams";
    this.axios.get(uri).then((response) => {
      this.teams = response.data;
    });
  },
};
</script>