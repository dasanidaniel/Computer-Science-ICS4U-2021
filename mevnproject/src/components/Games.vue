 <template>
  <div>
    <div>
      <div>
        <div>Games</div>

        <div>This is where a table with overall statistics will be placed.</div>
        <div>
          <table class="table table-hover">
            <thead>
              <tr>
                <th>Games</th>
                <th>Edit</th>
                <th>Delete</th>
                
              </tr>
            </thead>

            <tbody>
              <tr v-for="game in games" :key="game._id">
                <td>{{ game.teamOne }}   {{ game.teamOneScore }} - {{ game.teamTwoScore }}   {{ game.teamTwo }} </td>

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
    deleteTeam(id) {
      let uri = `//localhost:5000/games/delete/${id}`;
      this.axios.delete(uri).then((response) => {
        this.teams = this.teams.filter((r) => r._id != id);
        console.log(response.data);
      });
    },
  },
  created() {
    let uri = "http://localhost:5000/games";
    this.axios.get(uri).then((response) => {
      this.teams = response.data;
    });
  },
};
</script>