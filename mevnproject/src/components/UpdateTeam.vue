 <template>
  <div>
    <div>
      <h1>Edit</h1>
    </div>
    <form @submit.prevent="updateTeam">
      <div class="row">
        <div class="col-md-6">
          <div class="form-group">
            <label>Team Name:</label>
            <input type="text" class="form-control" v-model="team.name" />
          </div>
        </div>
      </div>

      <br />
      <div class="form-group">
        <button class="btn btn-primary">Update</button>
      </div>
    </form>
  </div>
</template>
 <script>
export default {
  
      data() {
        return {
          team: {}
        }
      },

      methods: {
        updateTeam() {
          let uri = `http://localhost:5000/teams/update/${this.$route.params.id}`;
          this.axios.post(uri, this.team).then(() => {
            this.$router.push({name: 'teams'});
          });
        }
      }
};
</script>