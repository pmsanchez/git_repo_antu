
package com.example.antoniobrito.td_challenge_project.augmentedimage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.google.ar.core.AugmentedImage;
import com.example.antoniobrito.td_challenge_project.WebViewAct;
import com.example.antoniobrito.td_challenge_project.augmentedimage.MainActivity;
import com.example.antoniobrito.td_challenge_project.augmentedimage.R;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ViewRenderable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AugmentedImageNode extends AnchorNode implements View.OnClickListener {

    private AugmentedImage image;
    private Context context;
    private ViewRenderable renderableView;

    public AugmentedImageNode(Context context) {
        this.context = context;

        CompletableFuture<ViewRenderable> viewCompFuture =
                ViewRenderable.builder().setView(context, R.layout.layout_renderable).build();

        CompletableFuture.allOf(viewCompFuture)
                .handle((notUsed, throwable) -> {
                    try {
                        renderableView = viewCompFuture.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    return null;
                });
    }

    public void setImage(AugmentedImage image) {
        this.image = image;

        CompletableFuture<ViewRenderable> viewCompFuture =
                ViewRenderable.builder().setView(context, R.layout.layout_renderable).build();

        CompletableFuture.allOf(viewCompFuture)
                .handle((notUsed, throwable) -> {
                    try {
                        renderableView = viewCompFuture.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    return null;
                });

        setAnchor(image.createAnchor(image.getCenterPose()));

        Node controls = new Node();
        controls.setParent(this);
        controls.setLocalPosition(new Vector3(0.0f, 0.0f, 0.0f));
        controls.setRenderable(renderableView);

        View renderableLayout = renderableView.getView();

        listeners(renderableLayout);
    }

    private void listeners(View renderableLayout) {
        renderableLayout.findViewById(R.id.bankaccountV).setOnClickListener(this);
        renderableLayout.findViewById(R.id.borrowingV).setOnClickListener(this);
        renderableLayout.findViewById(R.id.creditcardV).setOnClickListener(this);
        renderableLayout.findViewById(R.id.investmentV).setOnClickListener(this);
        renderableLayout.findViewById(R.id.smallbussV).setOnClickListener(this);
    }

    public AugmentedImage getImage() {
        return image;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bankaccountV:
                openBankActivity();
                break;
            case R.id.borrowingV:
                openWebAct(context.getString(R.string.td_borrowing_url));
                break;
            case R.id.creditcardV:
                openWebAct(context.getString(R.string.td_credit_Cards_url));
                break;
            case R.id.investmentV:
                openWebAct(context.getString(R.string.td_investment_url));
                break;
            case R.id.smallbussV:
                openWebAct(context.getString(R.string.td_smallbusiness_url));
                break;
        }
    }

    private void openWebAct(String url) {
        context.startActivity(new Intent(context, WebViewAct.class).putExtra(context.getString(R.string.int__web_view_act__url), url));
    }

    private void openBankActivity() {
        context.startActivity(new Intent(context, bankAccountAct.class));
    }


}
