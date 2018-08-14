package com.async.cloudconvert;

import com.async.cloudconvert.service.Process;

/**
 * @author Ankit Singh
 */
public class App {
    public static void main(String[] args) {
        CloudConvert cloudConvert=new CloudConvert("Cnkye1uS4LYBT5kgPV0mcTfW0liPwgE37tDUMIJdHRXIFSadyZaQ1Sv1xnMfG6DQ");
       try(Process process= cloudConvert.createAndStartSyncProcess("doc","pdf")){
           System.out.println("Response : "+process.getResponse().get().getAsString());
       }catch (Exception ex){

       }

    }
}
