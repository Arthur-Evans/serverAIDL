package com.wjx.serveraidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;


public class MathService extends Service {


    public MathService() {
    }


    private final IMathService.Stub binder = new IMathService.Stub() {
        @Override
        public int add(int a, int b) throws RemoteException {
            return a+b;
        }

        @Override
        public int subtract(int a, int b) throws RemoteException {
            return a-b;
        }

        @Override
        public int multiply(int a, int b) throws RemoteException {
            return a*b;
        }

        @Override
        public int divide(int a, int b) throws RemoteException {
            if (b == 0) throw new ArithmeticException("Cannot divide by zero");
            return a / b;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return binder;
    }
}