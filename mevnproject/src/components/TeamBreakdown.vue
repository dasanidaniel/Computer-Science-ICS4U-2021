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
                <th>Position</th>
                <th>Name</th>
                <th>W</th>
                <th>L</th>
                <th>W/L</th>
                
               
                <th>CONF</th>
                <th>PPG</th>
                <th>OPP PPG</th>
                <th>DIFF</th>

              
              
              </tr>
            </thead>

            <tbody class="bg-light">
              <tr v-for="(team, index) in eTeams" :key="team._id">
                <td>{{ doMath(index)}}</td>
                <td>{{ team.name }}</td>
                <td>{{ team.win }}</td>
                <td>{{ team.loss }}</td>
                <td>{{ calculate(team.win / team.loss) }}</td>
           
              
                <td>{{ team.confRecord.win }}-{{ team.confRecord.loss }}</td>
                <td>{{ calculate(team.PPG / team.numGames) }}</td>
                <td>{{ calculate(team.oppPPG / team.numGames)}}</td>
                <td>{{ calculate(team.avgDiff) }}</td>
               
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
                <th>Position</th>
                <th>Name</th>
                <th>W</th>
                <th>L</th>
                <th>W/L</th>
             
               
                <th>CONF</th>
                <th>PPG</th>
                <th>OPP PPG</th>
                <th>DIFF</th>

              
                
              </tr>
            </thead>

            <tbody class="bg-light">
              <tr v-for="(team,index) in wTeams" :key="team._id">
                <td>{{ doMath(index) }}
                <td>{{ team.name }}</td>
                <td>{{ team.win }}</td>
                <td>{{ team.loss }}</td>
                <td>{{ calculate(team.win / team.loss) }}</td>
                
              
                <td>{{ team.confRecord.win }}-{{ team.confRecord.loss }}</td>
                <td>{{ calculate(team.PPG / team.numGames)}}</td>
                <td>{{ calculate(team.oppPPG / team.numGames)}}</td>
                <td>{{ calculate(team.avgDiff) }}</td>
           

              
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
    doMath(index) {
      return index+1;
    },
    calculate(number) {
      return number.toFixed(1);
    },
  },
  // takes teams collection, filters into east and western conferences, and sorts it starting with the team with the most wins and least losses
  created() {
    let uri = "http://localhost:5000/teams/teams";
    this.axios.get(uri).then((response) => {
      this.eTeams = response.data.filter((team) => team.conference === 'East').sort((a,b) => a.confRecord.win - a.confRecord.loss > b.confRecord.win - b.confRecord.loss? -1 : 1);
      this.wTeams = response.data.filter((team) => team.conference === 'West').sort((a,b) => a.confRecord.win - a.confRecord.loss> b.confRecord.win - b.confRecord.loss? -1 : 1);
    });
  },
};
</script>