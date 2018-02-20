package iceblood.computercomponents.model.objects;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by Titan'ik on 08.02.2018.
 */

public class SimpleProcessor {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("codename")
        @Expose
        private String codename;
        @SerializedName("threads")
        @Expose
        private Integer threads;
        @SerializedName("cores")
        @Expose
        private Integer cores;

        public SimpleProcessor(int id,String name,String codename,int threads,int cores){
            this.id = id;
            this.name = name;
            this.codename = codename;
            this.threads = threads;
            this.cores = cores;
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

        public String getCodename() {
            return codename;
        }

        public void setCodename(String codename) {
            this.codename = codename;
        }

        public Integer getThreads() {
            return threads;
        }

        public void setThreads(Integer threads) {
            this.threads = threads;
        }

        public Integer getCores() {
            return cores;
        }

        public void setCores(Integer cores) {
            this.cores = cores;
        }

}


