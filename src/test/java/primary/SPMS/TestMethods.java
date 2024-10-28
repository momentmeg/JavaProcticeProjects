package primary.SPMS;

import org.junit.Test;

/**
 * @FileName TestMethods
 * @Description
 * @Author fahrtwind
 * @date 2024-10-24
 **/


public class TestMethods {

    @Test
    public void test(){
        ManageService manageService = new ManegeServiceImpl();
        manageService.add();
    }
}
