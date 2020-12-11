 <template>
  <div>
    <div>
      <h1>New Game</h1>
    </div>
    <form @submit.prevent="addGame">
      <div class="row">
        <div class="col-md-6">
          <div class="form-group">
            <label>Date:</label>
            <input
              type="text"
              class="form-control"
              v-model="game.date"
              placeholder="Date"
            />
          </div>
        </div>
      </div>
      <div>
        <table class="table table-hover">
          <thead></thead>

          <tbody>
            <tr>
              <td>
                <div class="col-md-6">
                  <div class="form-group">
                    <label>Home Team:</label>
                    <select class="form-control form-control-lg" v-model="game.homeTeam">
                      <option v-for="team in teams" :key="team._id">{{ this.team.name }}</option>
                    </select>
                  </div>
                </div>
              </td>

              <td>
                <div class="col-md-6">
                  <div class="form-group">
                    <label>Away Team:</label>
                    <input
                      type="text"
                      class="form-control"
                      v-model="game.awayTeam"
                      placeholder="Team Two"
                    />
                  </div>
                </div>
              </td>
            </tr>
            <tr>
              <td>
                <div class="col-md-6">
                  <div class="form-group">
                    <label>Score:</label>
                    <input
                      type="text"
                      class="form-control"
                      v-model="game.homeScore"
                      placeholder="Score"
                      oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"
                    />
                  </div>
                </div>
              </td>

              <td>
                <div class="col-md-6">
                  <div class="form-group">
                    <label>Score:</label>
                    <input
                      type="text"
                      class="form-control"
                      v-model="game.awayScore"
                      placeholder="Score"
                      oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"
                    />
                  </div>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>

      <br />
      <div class="form-group">
        <button class="btn btn-primary">Create</button>
      </div>
    </form>
  </div>
</template>
 <script>
export default {
  data() {
    return {
      game: {},
      team: {},
    };
  },
  methods: {
    addGame() {
      let uri = "http://localhost:5000/games/add";
      this.axios.post(uri, this.game).then(() => {
        this.$router.push({ name: "gamePage" });
      });
    },
  },
};
</script>