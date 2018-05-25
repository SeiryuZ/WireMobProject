package com.example.mrtbkwjn.a2018asiangamesapp;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;


import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int RC_SIGN_IN = 9001;
    private ImageButton googleButton = (ImageButton) findViewById(R.id.googleLoginButton);
    private ImageButton facebookButton = (ImageButton) findViewById(R.id.facebookLoginButton);
    private GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mobileAuth;
    private static final String TAG = "GoogleActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.googleLoginButton).setOnClickListener(this);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        mobileAuth = FirebaseAuth.getInstance();


    }
    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser currentUser = mobileAuth.getCurrentUser();
        if (currentUser != null) {
            String name = currentUser.getDisplayName();
            String email = currentUser.getEmail();
            Uri photoUrl = currentUser.getPhotoUrl();
            boolean emailVerified = currentUser.isEmailVerified();
            String uid = currentUser.getUid();

        } else {
            // No user is signed in
        }

        updateUI(currentUser);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // [START_EXCLUDE]
                updateUI(null);
                // [END_EXCLUDE]
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct)   {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
        // [START_EXCLUDE silent]
        showProgressDialog();
        // [END_EXCLUDE]

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mobileAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "Sign-in Success");
                            FirebaseUser user = mobileAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "Sign-in Failed", task.getException());
                            Snackbar.make(findViewById(R.id.activity_login), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // [START_EXCLUDE]
                        hideProgressDialog();
                        // [END_EXCLUDE]
                    }
                });
    }

    // [START signin]
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    // [END signin]


    private void onConnectionFailed (ConnectionResult connectionResult){
        Log.d(TAG, "onConnectionFailed" + connectionResult);
    }


    private void revokeAccess() {
        // Firebase sign out
        mobileAuth.signOut();

        // Google revoke access
        mGoogleSignInClient.revokeAccess().addOnCompleteListener(this,
                new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        updateUI(null);
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
        hideProgressDialog();
        if (user != null) {

            findViewById(R.id.googleLoginButton).setVisibility(View.GONE);

        } else {

            findViewById(R.id.googleLoginButton).setVisibility(View.VISIBLE);
        }
    }




    @Override
    public void onClick(View view){

        Intent menuIntent = new Intent (LoginActivity.this, MenuActivity.class);

        if(view == googleButton){
            signIn();
            startActivity(menuIntent);

        }
        else if (view == facebookButton){
            startActivity(menuIntent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("main", "ONRESUME");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("main", "ONPAUSE");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("main", "ONSTOP");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("main", "ONDESTROY");
    }

}
