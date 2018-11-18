package com.example.antoniobrito.td_challenge_project.augmentedimage;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class bankAccountAct extends AppCompatActivity implements View.OnDragListener, View.OnLongClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_account);

        // To generate pulse animations on Buttons
        ImageView ivBtnChequings = (ImageView) findViewById(R.id.btnChequings);
        ImageView ivBtnElectronic = (ImageView) findViewById(R.id.btnElectronicBank);
        ImageView ivBtnSavings = (ImageView) findViewById(R.id.btnSavings);
        ImageView ivBtnRelatedServ = (ImageView) findViewById(R.id.btnRelatedServ);
        ImageView ivBtnUsDollar = (ImageView) findViewById(R.id.btnUsDollar);
        ImageView ivMoneyBag = (ImageView) findViewById(R.id.moneyBag);

        //Declare Object Animator
        ObjectAnimator animChequings = ObjectAnimator.ofPropertyValuesHolder(ivBtnChequings, PropertyValuesHolder.ofFloat("scaleX", 1.2f), PropertyValuesHolder.ofFloat("scaleY", 1.2f));
        ObjectAnimator animElectronic = ObjectAnimator.ofPropertyValuesHolder(ivBtnElectronic, PropertyValuesHolder.ofFloat("scaleX", 1.2f), PropertyValuesHolder.ofFloat("scaleY", 1.2f));
        ObjectAnimator animSavings = ObjectAnimator.ofPropertyValuesHolder(ivBtnSavings, PropertyValuesHolder.ofFloat("scaleX", 1.2f), PropertyValuesHolder.ofFloat("scaleY", 1.2f));
        ObjectAnimator animRelatedServ = ObjectAnimator.ofPropertyValuesHolder(ivBtnRelatedServ, PropertyValuesHolder.ofFloat("scaleX", 1.2f), PropertyValuesHolder.ofFloat("scaleY", 1.2f));
        ObjectAnimator animUsDollar = ObjectAnimator.ofPropertyValuesHolder(ivBtnUsDollar, PropertyValuesHolder.ofFloat("scaleX", 1.2f), PropertyValuesHolder.ofFloat("scaleY", 1.2f));
        ObjectAnimator[] animObjs = {animChequings,animElectronic,animSavings,animRelatedServ,animUsDollar};

        //Start the Animation Object
        for(int i = 0; i < animObjs.length; i++){
            animObjs[i].setDuration(310);
            animObjs[i].setRepeatCount(ObjectAnimator.INFINITE);
            animObjs[i].setRepeatMode(ObjectAnimator.REVERSE);
            animObjs[i].start();
        }

        //Set listeners for Drag and Drop Action
        ivBtnChequings.setOnLongClickListener(this);
        ivBtnElectronic.setOnLongClickListener(this);
        ivBtnSavings.setOnLongClickListener(this);
        ivBtnRelatedServ.setOnLongClickListener(this);
        ivBtnUsDollar.setOnLongClickListener(this);
        //Set Drag Listener
        ivMoneyBag.setOnDragListener(this);
    }

    public void selectBankAccount(View view) {
        int btn = view.getId();
        Intent intent =null;
        switch (view.getId())
        {
            case R.id.btnChequings  :
                intent = new Intent(this,bankaccountOptionsActivity.class);
                break;
        }
        startActivity(intent);
    }

    @Override
    public boolean onLongClick(View view) {
        ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());
        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
        ClipData dragData = new ClipData((CharSequence) view.getTag(), new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN}, item);

        view.startDrag(dragData//data to be dragged
                , shadowBuilder //drag shadow
                , view//local data about the drag and drop operation
                , 0//no needed flags
        );
        return false;
    }

    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {
        int action = dragEvent.getAction();
        // Handles each of the expected events
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:

                final View vItem = (View) dragEvent.getLocalState();

                if ( vItem.getId() == R.id.btnChequings)
                {
                    Toast.makeText(this, "Chequing Account is Selected " , Toast.LENGTH_SHORT).show();
                }
                else if ( vItem.getId() == R.id.btnElectronicBank)
                {
                    Toast.makeText(this, "Electronic Banking is Selected " , Toast.LENGTH_SHORT).show();
                }
                else if ( vItem.getId() == R.id.btnSavings)
                {
                    Toast.makeText(this, "Savings Accounts is Selected" , Toast.LENGTH_SHORT).show();
                }
                else if ( vItem.getId() == R.id.btnRelatedServ)
                {
                    Toast.makeText(this, "Related Services is Selected" , Toast.LENGTH_SHORT).show();
                }
                else if ( vItem.getId() == R.id.btnUsDollar)
                {
                    Toast.makeText(this, "US Dollar Accounts is Selected" , Toast.LENGTH_SHORT).show();
                }
                return true;

            case DragEvent.ACTION_DRAG_ENTERED:
                return true;
            case DragEvent.ACTION_DRAG_LOCATION:
                // Ignore the event
                return true;
            case DragEvent.ACTION_DRAG_EXITED:

                return true;
            case DragEvent.ACTION_DROP:

                final View vItem2 = (View) dragEvent.getLocalState();

                if ( vItem2.getId() == R.id.btnChequings)
                {
                    float X = dragEvent.getX();
                    float Y = dragEvent.getY();
                    Intent intent =null;
                    intent = new Intent(this,chequingAccActivity.class);
                    startActivity(intent);
                    // finish();
                }
                if ( vItem2.getId() == R.id.btnElectronicBank)
                {
                    float X = dragEvent.getX();
                    float Y = dragEvent.getY();
                    Intent intent =null;
                    intent = new Intent(this,bankaccountOptionsActivity.class);
                    startActivity(intent);
                    finish();
                }
                if ( vItem2.getId() == R.id.btnSavings)
                {
                    float X = dragEvent.getX();
                    float Y = dragEvent.getY();
                    Intent intent =null;
                    intent = new Intent(this,bankaccountOptionsActivity.class);
                    startActivity(intent);
                    finish();
                }
                if ( vItem2.getId() == R.id.btnRelatedServ)
                {
                    float X = dragEvent.getX();
                    float Y = dragEvent.getY();
                    Intent intent =null;
                    intent = new Intent(this,bankaccountOptionsActivity.class);
                    startActivity(intent);
                    finish();
                }
                if ( vItem2.getId() == R.id.btnUsDollar)
                {
                    float X = dragEvent.getX();
                    float Y = dragEvent.getY();
                    Intent intent =null;
                    intent = new Intent(this,bankaccountOptionsActivity.class);
                    startActivity(intent);
                    finish();
                }
                return true;
            case DragEvent.ACTION_DRAG_ENDED:
                return true;
            // An unknown action type was received.
            default:
                Log.e("DragDrop Action", "Unknown action type received by OnDragListener.");
                break;
        }
        return false;
    }
}
