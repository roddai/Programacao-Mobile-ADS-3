package layout;

<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"android:layout_width="match_parent"android:layout_height="match_parent"android:orientation="vertical"android:padding="24dp">
<TextView android:id="@+id/textView"android:layout_width="match_parent"android:layout_height="wrap_content"android:layout_marginTop="30sp"android:gravity="center"android:text="Tela 1"android:textSize="50sp"/>
<EditText android:id="@+id/editNome"android:layout_width="match_parent"android:layout_height="wrap_content"android:layout_marginTop="50sp"android:hint="Digite seu nome"android:textSize="30sp"/>
<Button android:id="@+id/btnEnviar"android:layout_width="match_parent"android:layout_height="wrap_content"android:layout_marginLeft="60dp"android:layout_marginTop="50dp"android:layout_marginRight="60dp"android:padding="20dp"android:text="Enviar"android:textSize="30sp"android:backgroundTint="@color/blue"/>
</LinearLayout>