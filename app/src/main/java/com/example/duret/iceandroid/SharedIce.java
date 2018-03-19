package com.example.duret.iceandroid;

import android.util.Log;
import server.*;

import static android.content.ContentValues.TAG;

public class SharedIce {
    private static IServerPrx serverPrx = null;
    private static final int port = 8090;
    //private static final String ip = "192.168.1.32";
    private static final String ip = "10.126.1.5";
    public static final String URL = "http://"+ip+":"+port+"/music.mp3";

    private SharedIce() {

    }

    public static IServerPrx getInstance() {
        if (serverPrx == null) {
            try (com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize()) {
                com.zeroc.Ice.ObjectPrx base = communicator.stringToProxy("Serveur:tcp -h " + ip + " -p 10000");
                IServerPrx serverObject = IServerPrx.checkedCast(base);
                if (serverObject == null) {
                    throw new Error("Invalid proxy");
                }

                serverPrx = serverObject;
            }
            catch (com.zeroc.Ice.ConnectionRefusedException e) {
                System.out.println("Veuillez lancer le serveur avant le client s'il vous plait.");
            }
            catch (Throwable e) {
                System.out.println("\n\033[31;1mUne erreur est survenue pendant l'execution de l'application.\033[0m\n");
                Log.e(TAG, "getInstance: "+e.getMessage()+"\n");
                e.printStackTrace();
            }
        }
        return serverPrx;
    }
}
