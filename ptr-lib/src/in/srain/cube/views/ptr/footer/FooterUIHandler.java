package in.srain.cube.views.ptr.footer;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 *
 */
public interface FooterUIHandler {

    /**
     * perform reset UI (also when loading complete)
     * @param frame
     */
    void onUIReset(PtrFrameLayout frame);


    /**
     * perform loading UI
     */
    void onUILoading(PtrFrameLayout frame);

    /**
     * perform loading failed UI
     */
    void onUILoadingFailed(PtrFrameLayout frame);

    /**
     * perform end UI
     * @param frame
     */
    void onUIEnd(PtrFrameLayout frame);

}
