package universityofmalaya.mysurvival;

/**
 * Created by sopnopriyo on 04/04/2015.
 */
public class RowItem {

    private String title;
    private int profile_pic_id;
    private String description;
   // private String contactType;

    public RowItem(String title, int profile_pic_id, String description) {

        this.title = title;
        this.profile_pic_id = profile_pic_id;
        this.description = description;
       // this.contactType = contactType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProfile_pic_id() {
        return profile_pic_id;
    }

    public void setProfile_pic_id(int profile_pic_id) {
        this.profile_pic_id = profile_pic_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
/*
    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }
    */

}