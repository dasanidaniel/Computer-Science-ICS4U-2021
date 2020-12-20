 <template>
  <div class="container-fluid">
    <div>
      <h1>Edit</h1>
    </div>
    <form>
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
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-6">
          <div class="form-group">
            <select class="form-control" v-model="team.conference">
              <option>East</option>
              <option>West</option>
              <br />
            </select>
            <p v-if="!confIsValid" class="error-message">
              Name Field is required
            </p>
          </div>
        </div>
      </div>
      <br />
      <div class="form-group">
        <button v-on:click="updateTeam" class="btn btn-primary">Update</button>
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
  computed: {
    confIsValid() {
      return !!this.team.conference;
    },
    nameIsValid() {
      return !!this.team.name;
    },
  },

  methods: {
    cancel() {
      this.$router.push({ name: "teams" });
    },
    updateTeam() {
      let teamIsValid = this.confIsValid && this.nameIsValid;
      if (!teamIsValid) {
        alert("MISSING DATA");
      } else {
        let uri = `http://localhost:5000/teams/updateTeam/${this.$route.params.id}`;
        this.axios.post(uri, this.team);

        this.$router.push({ name: "teams" });
      }
    },
  },
};
</script>