 <template>
  <div class="container-fluid">
    <div>
      <h1>Edit Game</h1>
    </div>
    <form>
      <div class="row">
        <div class="col-md-6">
          <div class="form-group">
            <label>Date:</label>
            <input type="date" class="form-control" v-model="game.date" />
            <p v-if="!dateIsValid" class="error-message">
              Date field is required
            </p>
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
                    <select
                      class="form-control form-control-lg"
                      v-model="game.homeTeam"
                    >
                      <option v-for="team in teams" :key="team._id">
                        {{ team.name }}
                      </option>
                    </select>
                    <p v-if="!homeIsValid" class="error-message">
                      Team is required
                    </p>
                  </div>
                </div>
              </td>

              <td>
                <div class="col-md-6">
                  <div class="form-group">
                    <label>Away Team:</label>
                    <select
                      class="form-control form-control-lg"
                      v-model="game.awayTeam"
                    >
                      <option v-for="team in teams" :key="team._id">
                        {{ team.name }}
                      </option>
                    </select>
                    <p v-if="!awayIsValid" class="error-message">
                      Team is required
                    </p>
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
                    <p v-if="!homeScoreIsValid" class="error-message">
                      Score is required
                    </p>
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
                    <p v-if="!awayScoreIsValid" class="error-message">
                      Score is required
                    </p>
                  </div>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>

      <br />
      <div class="form-group">
        <button v-on:click="updateGame" class="btn btn-primary">Update</button>
        <button v-on:click="cancel" class="btn btn-danger">Cancel</button>
      </div>
    </form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      game: {},
      teams: [],
    };
  },
  created() {
    let uri = "http://localhost:5000/teams/teams";
    this.axios.get(uri).then((response) => {
      this.teams = response.data;
    });
  },
  computed: {
    dateIsValid() {
      return !!this.game.date;
    },
    awayIsValid() {
      return !!this.game.awayTeam;
    },
    homeIsValid() {
      return !!this.game.homeTeam;
    },
    homeScoreIsValid() {
      return !!this.game.homeScore;
    },
    awayScoreIsValid() {
      return !!this.game.awayScore;
    },
  },

  methods: {
    cancel() {
      this.$router.push({ name: "gamePage" });
    },
    updateGame() {
      let gameIsValid =
        this.dateIsValid &&
        this.awayIsValid &&
        this.homeIsValid &&
        this.homeScoreIsValid &&
        this.awayScoreIsValid;

      if (gameIsValid) {
     
        let url = `http://localhost:5000/games/update/${this.$route.params.id}`;
        this.axios.post(url, this.game);
        this.$router.push({ name: "gamePage" });
      } else {
        alert("MISSING INFORMATION");
      }
    },
  },
};
</script>