//==============================================================================
//  WARNING!!  This file is overwritten by the Block UI Styler while generating
//  the automation code. Any modifications to this file will be lost after
//  generating the code again.
//
//       Filename:  C:\\workplace\\NX\NXDEV2.0\\workdir\\application\\Task05.java
//
//        This file was generated by the NX Block UI Styler
//        Created by: 26069
//              Version: NX 12
//              Date: 06-19-2020  (Format: mm-dd-yyyy)
//              Time: 16:28 (Format: hh-mm)
//
//==============================================================================

//==============================================================================
//  Purpose:  This TEMPLATE file contains JAVA source to guide you in the
//  construction of your Block application dialog. The generation of your
//  dialog file (.dlx extension) is the first step towards dialog construction
//  within NX.  You must now create a NX Open application that
//  utilizes this file (.dlx).
//
//  The information in this file provides you with the following:
//
//  1.  Help on how to load and display your Block UI Styler dialog in NX
//      using APIs provided in NXOpen.BlockStyler namespace
//  2.  The empty callback methods (stubs) associated with your dialog items
//      have also been placed in this file. These empty methods have been
//      created simply to start you along with your coding requirements.
//      The method name, argument list and possible return values have already
//      been provided for you.
//==============================================================================

//------------------------------------------------------------------------------
//These imports are needed for the following template code
//------------------------------------------------------------------------------
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import nxopen.*;
import nxopen.blockstyler.*;

//------------------------------------------------------------------------------
//Represents Block Styler application class
//------------------------------------------------------------------------------
public class Task05 implements BlockDialog.Initialize, BlockDialog.DialogShown, BlockDialog.Apply, BlockDialog.Ok, BlockDialog.Update
//,ListBox.AddCallback
//,ListBox.DeleteCallback
{
    //class members
    public static Session theSession = null;
    public static UI theUI = null;
    private String theDlxFileName;
    private BlockDialog theDialog;
    private ListBox list_box;// Block type: List Box
    private StringBlock string;// Block type: String
    private FolderSelection nativeFolder;// Block type: NativeFolderBrowser
    private List<Plain> plains;
    //定义表格文件所在的位置
    public static final String filePath = "C:\\workplace\\IDEA\\NXDEV\\nx_practical_training\\src\\main\\resources\\plain.xlsx";
    //------------------------------------------------------------------------------
    //Constructor for NX Styler class
    //------------------------------------------------------------------------------
    public Task05() throws Exception, RemoteException
    {
        try
        {
            theSession = (Session)SessionFactory.get("Session");
            theUI = (UI)SessionFactory.get("UI");
            theDlxFileName = "Task05.dlx";
            theDialog = theUI.createDialog(theDlxFileName);
            theDialog.addApplyHandler(this);
            theDialog.addOkHandler(this);
            theDialog.addUpdateHandler(this);
            theDialog.addInitializeHandler(this);
            theDialog.addDialogShownHandler(this);
            plains = new ArrayList<>();
        }
        catch(Exception ex)
        {
            //---- Enter your exception handling code here -----
            throw new Exception(ex);
        }
    }
    //------------------------------- DIALOG LAUNCHING ---------------------------------
    //
    //    Before invoking this application one needs to open any part/empty part in NX
    //    because of the behavior of the blocks.
    //
    //    Make sure the dlx file is in one of the following locations:
    //        1.) From where NX session is launched
    //        2.) $UGII_USER_DIR/application
    //        3.) For released applications, using UGII_CUSTOM_DIRECTORY_FILE is highly
    //            recommended. This variable is set to a full directory path to a file 
    //            containing a list of root directories for all custom applications.
    //            e.g., UGII_CUSTOM_DIRECTORY_FILE=$UGII_BASE_DIR\\ugii\\menus\\custom_dirs.dat
    //
    //    You can create the dialog using one of the following way:
    //
    //    1. USER EXIT
    //
    //        1) Create the Shared Library -- Refer "Block UI Styler programmer's guide"
    //        2) Invoke the Shared Library through File->Execute->NX Open menu.
    //
    //------------------------------------------------------------------------------
    public static void main(String [] argv) throws Exception
    {
        Task05 theTask05 = null;
        try
        {
            theTask05 = new Task05();
            // The following method shows the dialog immediately
            theTask05.show();
        }
        catch(Exception ex)
        {
            //---- Enter your exception handling code here -----
            theUI.nxmessageBox().show("Block Styler", NXMessageBox.DialogType.ERROR, ex.getMessage());
        }
        finally
        {
            if(theTask05 != null)
            {
                theTask05.dispose();
                theTask05 = null;
            }
        }
    }
    
    //------------------------------------------------------------------------------
    // This method specifies how a shared image is unloaded from memory
    // within NX. This method gives you the capability to unload an
    // internal NX Open application or user  exit from NX. Specify any
    // one of the three constants as a return value to determine the type
    // of unload to perform:
    //
    //
    //    Immediately : unload the library as soon as the automation program has completed
    //    Explicitly  : unload the library from the "Unload Shared Image" dialog
    //    AtTermination : unload the library when the NX session terminates
    //
    //
    // NOTE:  A program which associates NX Open applications with the menubar
    // MUST NOT use this option since it will UNLOAD your NX Open application image
    // from the menubar.
    //------------------------------------------------------------------------------
     public static final int getUnloadOption()
    {
        //return BaseSession.LibraryUnloadOption.EXPLICITLY;
         return BaseSession.LibraryUnloadOption.IMMEDIATELY;
        // return BaseSession.LibraryUnloadOption.AT_TERMINATION;
    }
    
    //------------------------------------------------------------------------------
    // Following method cleanup any housekeeping chores that may be needed.
    // This method is automatically called by NX.
    //------------------------------------------------------------------------------
    public static void onUnload() throws NXException, RemoteException
    {
        try
        {
        }
        catch(Exception ex)
        {
            //---- Enter your exception handling code here -----

            theUI.nxmessageBox().show("Block Styler", NXMessageBox.DialogType.ERROR, ex.getMessage());
        }
    }
    
    //------------------------------------------------------------------------------
    //This method shows the dialog on the screen
    //------------------------------------------------------------------------------
    public int show() throws NXException, RemoteException
    {
        try
        {
            theDialog.show();
        }
        catch(Exception ex)
        {
            //---- Enter your exception handling code here -----
            theUI.nxmessageBox().show("Block Styler", NXMessageBox.DialogType.ERROR, ex.getMessage());
        }
        return 0;
    }
    
    //------------------------------------------------------------------------------
    //Method Name: dispose
    //------------------------------------------------------------------------------
    public void dispose() throws NXException, RemoteException
    {
        if(theDialog != null)
        {
            theDialog.dispose();
            theDialog = null;
        }
    }
    
    //------------------------------------------------------------------------------
    //---------------------Block UI Styler Callback Functions--------------------------
    //------------------------------------------------------------------------------
    
    //------------------------------------------------------------------------------
    //Callback Name: initialize
    //------------------------------------------------------------------------------
    public void initialize() throws NXException, RemoteException
    {
        try
        {
            list_box = (ListBox)theDialog.topBlock().findBlock("list_box");
            string = (StringBlock)theDialog.topBlock().findBlock("string");
            nativeFolder = (FolderSelection)theDialog.topBlock().findBlock("nativeFolder");
            //------------------------------------------------------------------------------
            //Registration of ListBox specific callbacks
            //------------------------------------------------------------------------------
            //list_box.setAddHandler(this);
            
            //list_box.setDeleteHandler(this);
            
            //------------------------------------------------------------------------------
        }
        catch(Exception ex)
        {
            //---- Enter your exception handling code here -----
            theUI.nxmessageBox().show("Block Styler", NXMessageBox.DialogType.ERROR, ex.getMessage());
        }
    }
    
    //------------------------------------------------------------------------------
    //Callback Name: dialogShown
    //This callback is executed just before the dialog launch. Thus any value set 
    //here will take precedence and dialog will be launched showing that value. 
    //------------------------------------------------------------------------------
    public void dialogShown() throws NXException, RemoteException
    {
        try
        {
            //---- Enter your callback code here -----
            //读取表格文件中的所有的内容封装成一个Plain的list对象
            plains = ReadXLSX.readExcel(filePath);
            //使用stream流获取所有对象的类型
            String[] names = plains.stream()
                    .map(t -> t.getName()).toArray(String[]::new);
            //组件设置值
            list_box.setListItems(names);
        }
        catch(Exception ex)
        {
            //---- Enter your exception handling code here -----
            theUI.nxmessageBox().show("Block Styler", NXMessageBox.DialogType.ERROR, ex.getMessage());
        }
    }
    
    //------------------------------------------------------------------------------
    //Callback Name: apply
    //Following callback is associated with the "theDialog" Block.
    //------------------------------------------------------------------------------
    public int apply() throws NXException, RemoteException
    {
        int errorCode = 0;
        try
        {
            //---- Enter your callback code here -----

            //获取用户选择的标准件名称
            String[] selectedItemStrings = list_box.getSelectedItemStrings();

            //判断是否只选择了一个
            if (selectedItemStrings.length != 1) {
                throw new Exception("能且仅能选择一个型号的标准件！");
            }
            //获取用户输入的文件名
            String prtName = string.value();
            //文件名为空
            if (prtName == null || prtName.isEmpty()) {
                throw new Exception("请输入文件名！");
            }
            //判断用户输入是否为.prt文件类型名
            if(!prtName.contains(".prt")){
                //用户没有输入了.prt结尾
                prtName += ".prt";
            }
            //获取用户选择的文件保存路径
            String path = nativeFolder.path();
            //判空
            if (path == null || path.isEmpty()) {
                throw new Exception("请输入文件保存路径！");
            }
            //由模板文件创建新部件、修改表达式并按指定的名称和路径进行另存；
            createNewPlain(selectedItemStrings[0],path,prtName);
        }
        catch(Exception ex)
        {
            //---- Enter your exception handling code here -----
            errorCode = 1;
            theUI.nxmessageBox().show("Block Styler", NXMessageBox.DialogType.ERROR, ex.getMessage());
        }
        return errorCode;
    }

    /**
     *
     * @author mumulx
     * @email: 2606964863@qq.com
     * @date 2020/6/19 22:00
     * @param plainName 用户选择的标准件的名称(即型号名称如M2.M3)
     * @param path 文件保存路径
     * @param prtName 文件名
     * @return void
     */
    private void createNewPlain(String plainName,String path,String prtName) throws Exception {
        //1. 模板文件进行另存为
        File out = new File(path+prtName);
        //用户想保存的文件文件在保存路径已存在
        if (out.exists()) {
            throw new Exception("文件在该目录已经存在，请更换文件名或文件保存路径！");
        }
        //读取文件
        try(
                //采用此种写法方便流的关闭
            FileInputStream fin = new FileInputStream("D:\\NXTask\\task05.prt");
            FileOutputStream fos = new FileOutputStream(out);

        ) {
            byte datas[] = new byte[1024*8];//创建搬运工具
            int len = 0;//创建长度
            //循环读取数据
            while((len = fin.read(datas))!=-1){
                fos.write(datas,0,len);
            }
        } catch (Exception e) {
            //重新抛出异常交给NX去处理
            throw new Exception("文件复制失败！");
        }
        //2.打开复制的文件
        theSession.parts().openActiveDisplay(out.getPath(), nxopen.DisplayPartOption.ALLOW_ADDITIONAL);
        //3.获取该工作部件
        Part workPart = theSession.parts().work();
        theSession.parts().display();
        //4.修改表达式的值
        //获取该标准件的其他属性
        Plain plainByName = findPlainByName(plainName);
        //判空处理
        if (plainByName == null) {
            throw new Exception("找不到该型号的标准件！");
        }
        //获取对应的表达式对象
        ExpressionCollection expressions = workPart.expressions();
        Expression insideDiameter = expressions.findObject("inside_diameter");
        Expression outsideDiameter = expressions.findObject("outside_diameter");
        Expression thickness = expressions.findObject("thickness");

        //设置值
        insideDiameter.setValue(Double.valueOf(plainByName.getInsideDiameter()));
        outsideDiameter.setValue(Double.valueOf(plainByName.getOutsideDiameter()));
        thickness.setValue(Double.valueOf(plainByName.getThickness()));

        //保存文件
        workPart.save(nxopen.BasePart.SaveComponents.TRUE, nxopen.BasePart.CloseAfterSave.FALSE);

        //调整窗口
        workPart.modelingViews().workView().fit();
    }

    /**
     *
     * @author mumulx
     * @email: 2606964863@qq.com
     * @date 2020/6/19 22:06
     * @param plainName 标准件的名字
     * @return Plain
     *
     * 根据标准件的名字获取标准件的其他参数
     */
    private Plain findPlainByName(String plainName) {
        //使用stream流帮助我们过滤其余对象
        Plain plain = plains.stream()
                .filter(t -> t.getName().equals(plainName))
                .collect(Collectors.toList())
                .get(0);
        return plain;
    }

    //------------------------------------------------------------------------------
    //Callback Name: update
    //Following callback is associated with the "theDialog" Block.
    //------------------------------------------------------------------------------
    public int update( UIBlock block) throws NXException, RemoteException
    {
        try
        {
            if(block == list_box)
            {
            //---------Enter your code here-----------
            }
            else if(block == string)
            {
            //---------Enter your code here-----------
            }
            else if(block == nativeFolder)
            {
            //---------Enter your code here-----------
            }
        }
        catch(Exception ex)
        {
            //---- Enter your exception handling code here -----
            theUI.nxmessageBox().show("Block Styler", NXMessageBox.DialogType.ERROR, ex.getMessage());
        }
        return 0;
    }
    
    //------------------------------------------------------------------------------
    //Callback Name: ok
    //------------------------------------------------------------------------------
    public int ok() throws NXException, RemoteException
    {
        int errorCode = 0;
        try
        {
            //---- Enter your callback code here -----
            errorCode = apply();
        }
        catch(Exception ex)
        {
            //---- Enter your exception handling code here -----
            errorCode = 1;
            theUI.nxmessageBox().show("Block Styler", NXMessageBox.DialogType.ERROR, ex.getMessage());
        }
        return errorCode;
    }
    //------------------------------------------------------------------------------
    //ListBox specific callbacks
    //------------------------------------------------------------------------------
    //public int  addCallback (nxopen.blockstyler.ListBox list_box) throws NXException,RemoteException
    //{
    //}
    
    //public int  deleteCallback(nxopen.blockstyler.ListBox list_box) throws NXException,RemoteException
    //{
    //}
    
    //------------------------------------------------------------------------------
    
    //------------------------------------------------------------------------------
    //Function Name: GetBlockProperties
    //------------------------------------------------------------------------------
    public PropertyList getBlockProperties(String blockID) throws NXException, RemoteException
    {
        PropertyList plist = null;
        try
        {
            plist = theDialog.getBlockProperties(blockID);
        }
        catch(Exception ex)
        {
            //---- Enter your exception handling code here -----
            theUI.nxmessageBox().show("Block Styler", NXMessageBox.DialogType.ERROR, ex.getMessage());
        }
        return plist;
    }




}