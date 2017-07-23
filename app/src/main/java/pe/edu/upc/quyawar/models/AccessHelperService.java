package pe.edu.upc.quyawar.models;

import java.util.List;

/**
 * Created by Rafael on 23/07/2017.
 */

public class AccessHelperService {

    private final String TAG = "QuyawarApp";
    private AccessHelper accessHelper;


    public AccessHelperService() {
        init_accessHelper();
    }

    private void init_accessHelper(){
        if(accessHelper == null){
            List<AccessHelper> accesos = AccessHelper.listAll(AccessHelper.class);
            if(accesos.size() > 0){
                accessHelper = accesos.get(0);
            }else{
                accessHelper = new AccessHelper();
                accessHelper.setFirstAccess(true);
                accessHelper.save();
            }
        }
    }

    public boolean isFirstAccess(){
        if(!accessHelper.isFirstAccess()) {
            return false;
        }
        return true;
    }

    public void setFirstAccess(boolean value){
        accessHelper.setFirstAccess(value);
        accessHelper.save();
    }

}
