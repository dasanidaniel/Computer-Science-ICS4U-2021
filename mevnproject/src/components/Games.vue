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
                <th> </th>
                <th> </th>
                <th class="text-center">Games</th>
                <th> </th>
                <th> </th>
                <th>Date</th>
                <th>Edit</th>
                <th>Delete</th>
              </tr>
            </thead>

            <tbody>
              <tr v-for="game in games" :key="game._id">
                
                <td class="text-right"><b>{{ game.homeTeam }}</b></td>
                <td class="text-right">{{ game.homeScore }}</td>
                <td class="text-center"> - </td>
                <td class="text-left">{{ game.awayScore }}</td>
                <td class="text-left"> <b>{{ game.awayTeam }}</b> </td>
                
                <td>{{ game.date }} </td>

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
    };
  },

  methods: {
    deleteGame(id) {
      let uri = `//localhost:5000/games/delete/${id}`;
      this.axios.delete(uri).then((response) => {
        this.games = this.games.filter((r) => r._id != id);
        console.log(response.data);
      });
    },
    displayDate(d) {

      let date = "";
      if (d.getMonth() == 0) {
        date += "Jan.";
      } else if (d.getMonth() == 1) {
        date += "Feb.";
      } else if (d.getMonth() == 2) {
        date += "Mar.";
      } else if (d.getMonth() == 3) {
        date += "Apr.";
      } else if (d.getMonth() == 4) {
        date += "May.";
      } else if (d.getMonth() == 5) {
        date += "Jun.";
      } else if (d.getMonth() == 6) {
        date += "Jul.";
      } else if (d.getMonth() == 7) {
        date += "Aug.";
      } else if (d.getMonth() == 8) {
        date += "Sept.";
      } else if (d.getMonth() == 9) {
        date += "Oct.";
      } else if (d.getMonth() == 10) {
        date += "Nov.";
      } else {
        date += "Dec.";
      }
      date += " " + d.getDay() + ", " + d.getYear();
      return date;
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