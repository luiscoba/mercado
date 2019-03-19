package com.mercado.a.domicilio.config.utils;

import android.os.StrictMode;

public final class Permiso {
    /* MetodoPara que concede acceso a las politicas */
    public static void ejecutar_dispositivos_sdk_int_9() {
        //permisos para la ejecucion de hilos
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }
}
