@Component
@ConfigurationProperties(prefix= "google.api")
public class ConfigAPI{

      private String key;
      private String sheet_id;
      private String sheet_name;  


      public String getKey(){
            return key;

      }
      public void setKey(String key){
           this.key=key;

      }
      public getSheetId(){
           return sheet_id;


      }

}
