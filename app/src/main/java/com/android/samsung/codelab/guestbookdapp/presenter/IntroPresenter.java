package com.android.samsung.codelab.guestbookdapp.presenter;

import android.text.TextUtils;
import android.util.Log;

import com.android.samsung.codelab.guestbookdapp.contract.IntroContract;
import com.android.samsung.codelab.guestbookdapp.model.UserInfo;
import com.android.samsung.codelab.guestbookdapp.util.PrefsHelper;
import com.samsung.android.sdk.coldwallet.ScwDeepLink;
import com.samsung.android.sdk.coldwallet.ScwService;

import java.util.ArrayList;
import java.util.List;

public class IntroPresenter implements IntroContract.Presenter {

    private static final String TAG = IntroPresenter.class.getSimpleName();
    private IntroContract.View mContract;

    public IntroPresenter(IntroContract.View mContract) {
        this.mContract = mContract;
    }

    @Override
    public boolean initializeKeystore() {
        String cachedSeedHash = PrefsHelper.getInstance().getCachedSeedHash();

        /*
         * TODO :
         * Integrate Samsung blockchain Keystore
         *
         * 1. Check Samsung blockchain keystore is supported or not.
         *      - if not support, toast message to notify this device doesn't support keystore.
         * 2. Check installed api level
         *      - if api level is low, show dialog and jump to Galaxy store
         * 3. Check seed hash exist.
         *      - if seed hash is empty, jump to blockchain keystore to create or import wallet
         * 4. Compare seed hash cached with current
         *      - if the seed hash is different from cached, update seed hash and address
         *         then, go to next activity
         * 5. Success
         *      - Update address with cached address.
         *      - And go to next TimelineActivity
         */

        return true;
    }

    public void onClickBlockchainKeystore() {
        mContract.setLoading(true);
        boolean immediateInit = initializeKeystore();
        if (immediateInit) {
            mContract.setLoading(false);
        }
    }

    public void onClickInAppKeystore() {
        Log.d(TAG, "In-app Keystore is not supported");
    }

    private void getEthereumAddress(String hdpath, GetEthereumAddressCallback callback) {

        /*
         * TODO :
         * Get ethereum address with Samsung blockchain keystore
         * Use getAddressList API
         */

    }

    private void updateSeedHash(String seedHash) {
        PrefsHelper.getInstance().updateSeedHash(seedHash);
        UserInfo.getInstance().setSeedHash(seedHash);
    }

    private void updateAddress(String address) {
        PrefsHelper.getInstance().updateAddress(address);
        UserInfo.getInstance().setAddress(address);
    }

    interface GetEthereumAddressCallback {
        void OnAddressReceived(boolean success, int errorCode, String address, String seedHash);
    }
}
