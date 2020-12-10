 <template>
  <div>
    <div>
      <div>
        <div>Stats</div>

        <div>This is where a table with overall statistics will be placed.</div>
        <div>
          <table class="table table-hover">
            <thead>
              <tr>
                <th>Name</th>
                <th>W</th>
                <th>L</th>
                <th>W/L</th>
                <th>GB</th>
                <th>DIV</th>
                <th>CONF</th>
                <th>PPG</th>
                <th>OPP PPG</th>
                <th>DIFF</th>

                <th>L10</th>
                <th>EDIT</th>
                <th>DELETE</th>
              </tr>
            </thead>

            <tbody>
              <tr v-for="team in teams" :key="team._id">
                <td>{{ team.name }}</td>
                <td>{{ team.win }}</td>
                <td>{{ team.loss }}</td>
                <td>{{ team.PCT }}</td>
                <td>{{ team.GB }}</td>
                <td>{{ team.divRecord.win }}-{{team.divRecord.loss}}</td>
                <td>{{ team.confRecord.win }}-{{team.confRecord.loss }}</td>
                <td>{{ team.PPG }}</td>
                <td>{{ team.oppPPG }}</td>
                <td>{{ team.avgDiff }}</td>
                <td>{{ team.last10 }}</td>
                
                
                <td>
                  <router-link
                    :to="{ name: 'editTeam', params: { id: team._id } }"
                    class="btn btn-primary"
                    >Edit</router-link
                  >
                </td>
                <td>
                  <button
                    v-on:click="deletePost(team._id)"
                    class="btn btn-danger"
                  >
                    Delete
                  </button>
                </td>
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
          teams: []
        }
      },
      
    methods: {
    deleteTeam(id)
   {
    let uri = `//localhost:5000/teams/delete/${id}`;
    this.axios.delete(uri).then(response => {
     this.teams = this.teams.filter((r) => (r._id != id));
     console.log(response.data);
    });
   }
  },
  created() {
      let uri = 'http://localhost:5000/teams/teams';
      this.axios.get(uri).then(response => {
        this.teams = response.data;
      });
    }
};
</script>