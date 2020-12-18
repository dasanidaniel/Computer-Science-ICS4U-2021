 <template>
  <div class= "container-fluid">
    <div>
      <h1>New Team</h1>
    </div>
    <form @submit.prevent="addTeam">
      <div class="row">
        <div class="col-md-6">
          <div class="form-group">
            <label>Team Name:</label>
            <input
              type="text"
              class="form-control"
              v-model="team.name"
              placeholder="Name"
            />
             <p v-if="!nameIsValid" class="error-message">Name Field is required</p>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-6">
          <div class="form-group">
            <select
              class="form-control "
              v-model="team.conference">
              <option>East</option>
              <option>West</option>
              <br />
            </select>
             <p v-if="!confIsValid" class="error-message">Name Field is required</p>
          </div>
        </div>
      </div>
      <div class="form-group">
        <button class="btn btn-primary">Create</button>
        <button v-on:click="cancel" class="btn btn-danger">Cancel</button>
      </div>
    </form>
  </div>
</template>
 <script>
export default {
  data() {
    return {
      team: {},
    };
  },
  computed : {
    nameIsValid() {
      return !!this.team.name;
    },
    confIsValid() {
      return !!this.team.conference;
    }
  },
  methods: {
     cancel() {
          this.$router.push({name: 'teams'});
        },
    
    addTeam() {
      let teamIsValid = this.nameIsValid && this.confIsValid;
      if (teamIsValid) {
      let uri = "http://localhost:5000/teams/add";
      this.axios.post(uri, this.team).then(() => {
        this.$router.push({ name: "teams" });
      });
      } else {
        alert("MISSING DATA");
      }
    },
  },
};
</script>