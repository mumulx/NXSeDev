//  ==============================================================================
//  WARNING!!  This file is overwritten by the Block UI Styler while generating
//  the automation code. Any modifications to this file will be lost after
//  generating the code again.
//
//       Filename:  C:\workplace\NX\NXDEV2.0\workdir\application\row.java
//
//        This file was generated by the NX Block UI Styler
//        Created by: 26069
//              Version: NX 12
//              Date: 06-02-2020  (Format: mm-dd-yyyy)
//              Time: 09:58 (Format: hh-mm)
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
import java.rmi.RemoteException;
import nxopen.*;
import nxopen.blockstyler.*;

//------------------------------------------------------------------------------
//Represents Block Styler application class
//------------------------------------------------------------------------------
public class row implements BlockDialog.Initialize, BlockDialog.DialogShown, BlockDialog.Apply, BlockDialog.Ok, BlockDialog.Update
{
    //class members
    public static Session theSession = null;
    public static UI theUI = null;
    private String theDlxFileName;
    private BlockDialog theDialog;
    private static StringBlock title;// Block type: String
    private static StringBlock value;// Block type: String
    private static StringBlock type;// Block type: String
    
    //------------------------------------------------------------------------------
    //Constructor for NX Styler class
    //------------------------------------------------------------------------------
    public row() throws Exception, RemoteException
    {
        try
        {
            theSession = (Session)SessionFactory.get("Session");
            theUI = (UI)SessionFactory.get("UI");
            theDlxFileName = "row.dlx";
            theDialog = theUI.createDialog(theDlxFileName);
            theDialog.addApplyHandler(this);
            theDialog.addOkHandler(this);
            theDialog.addUpdateHandler(this);
            theDialog.addInitializeHandler(this);
            theDialog.addDialogShownHandler(this);
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
        row therow = null;
        try
        {
            therow = new row();
            // The following method shows the dialog immediately
            therow.show();
        }
        catch(Exception ex)
        {
            //---- Enter your exception handling code here -----
            theUI.nxmessageBox().show("Block Styler", NXMessageBox.DialogType.ERROR, ex.getMessage());
        }
        finally
        {
            if(therow != null)
            {
                therow.dispose();
                therow = null;
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
            title = (StringBlock)theDialog.topBlock().findBlock("title");
            value = (StringBlock)theDialog.topBlock().findBlock("value");
            type = (StringBlock)theDialog.topBlock().findBlock("type");
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
    //Callback Name: update
    //Following callback is associated with the "theDialog" Block.
    //------------------------------------------------------------------------------
    public int update( UIBlock block) throws NXException, RemoteException
    {
        try
        {
            if(block == title)
            {
            //---------Enter your code here-----------
            }
            else if(block == value)
            {
            //---------Enter your code here-----------
            }
            else if(block == type)
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