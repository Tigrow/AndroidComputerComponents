package iceblood.computercomponents.model.objects;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * POJO
 */

public class SimpleProcessor {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;

        private boolean isLiked;

        public SimpleProcessor(int id,String name,boolean isLiked){
            this.id = id;
            this.name = name;
            this.isLiked = isLiked;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isLiked() {
        return isLiked;
        }

        public void setLiked(boolean like) {
        isLiked = like;
        }

}


