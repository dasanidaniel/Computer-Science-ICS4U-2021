 <template>
  <div>
    <div>
      <h1>New Team</h1>
    </div>
    <form @submit.prevent="addTeam">
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
        <button class="btn btn-primary">Create</button>
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
  methods: {
    addTeam() {
      console.log(this.team);
    },
  },
};
</script>