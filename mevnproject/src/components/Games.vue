 <template>
  <div class="container">
    <div>
      <div>
        <div>
          <h3 class="text-center">Game History</h3>
          <h4>Filter: <button v-bind:class="active ? 'btn btn-success' : 'btn btn-danger'" v-on:click ="filterOn" >{{ status }}</button></h4>
          <input type="date" class="form-control" v-model="filter" />
          <table class="table table-hover">
            <thead class="thead-dark">
              <tr>
                <th class="text-right">Home</th>
                <th></th>
                <th class="text-center"></th>
                <th></th>
                <th>Away</th>
                <th>Date</th>
                <th>Edit</th>
                <th>Delete</th>
              </tr>
            </thead>

            <tbody class="bg-light">
              <tr v-for="game in games" :key="game._id">
                <td class="text-right">
                  <b>{{ game.homeTeam }}</b>
                </td>
                <td class="text-right">{{ game.homeScore }}</td>
                <td class="text-center">-</td>
                <td class="text-left">{{ game.awayScore }}</td>
                <td class="text-left">
                  <b>{{ game.awayTeam }}</b>
                </td>

                <td>
                  {{
                    game.date
                      | dateParse("YYYY-MM-DD")
                      | dateFormat("MMMM D, YYYY")
                  }}
                </td>

                <td>
                  <router-link
                    :to="{ name: 'editGame', params: { id: game._id } }"
                    class="btn btn-primary"
                    >Edit</router-link
                  >
                </td>
                <td>
                  <button
                    v-on:click="deleteGame(game._id)"
                    class="btn btn-danger"
                  >
                    Delete
                  </button>
                </td>
              </tr>
              <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>

                <td></td>

                <td>
                  <router-link :to="{ name: 'newGame' }" class="btn btn-primary"
                    >+ Game</router-link
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
      games: [],
      filter: "",
      active: false,
      status: "OFF"
    };
  },
  computed: {
    dateIsValid() {
      return !!this.filter;
    }
  },

  methods: {
    deleteGame(id) {
      let uri = `//localhost:5000/games/delete/${id}`;
      this.axios.delete(uri).then((response) => {
        this.games = this.games.filter((r) => r._id != id);
        console.log(response.data);
      });
    },
    filterOn() {
      if (!this.filter) {
        alert("No Date chosen");
      } else { 
      this.active = !this.active;
      if (this.active) {
        this.status = "ON";
          this.games = this.games.filter(game => {
            
            let filterDate = this.filter.toString() + "T00:00:00.000Z";
            if (filterDate === game.date) {
              return game;
            }
          });
      } else {
        this.status = "OFF";
         let uri = "http://localhost:5000/games/games";
    this.axios.get(uri).then((response) => {
      this.games = response.data;
    });
      }
      }
    }
  },
  created() {
    let uri = "http://localhost:5000/games/games";
    this.axios.get(uri).then((response) => {
      this.games = response.data;
    });
  },
};
</script>