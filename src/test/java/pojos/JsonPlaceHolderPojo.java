package pojos;

public class JsonPlaceHolderPojo {
    //Create private variables for each field

    private Integer userId ;
    private String title ;
    private Boolean completed ;

  // {
  //     "userId": 55,
  //         "title": "Tidy your room",
  //         "completed": false
  // }
    //Create constructors with parameters and without parameters

    public JsonPlaceHolderPojo() {
    }

    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    //Create Getters and Setters

    public Integer getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }



    //Create ToString


    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
