/*
 * Copyright (c) 2015 PocketHub
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.pockethub.android.ui.base

import android.os.Parcelable
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.annotation.CallSuper
import com.github.pockethub.android.ui.OptionsMenuListener
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment() {

    var optionsMenuListener: OptionsMenuListener? = null

    /**
     * Get parcelable extra from activity's intent
     */
    protected fun <V : Parcelable> getParcelableExtra(name: String): V? {
        return activity?.intent?.getParcelableExtra(name)
    }

    /**
     * Get string extra from activity's intent
     */
    protected fun getStringExtra(name: String): String? {
        return activity?.intent?.getStringExtra(name)
    }

    @CallSuper
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        optionsMenuListener?.onCreateOptionsMenu(menu, inflater)
        super.onCreateOptionsMenu(menu, inflater)
    }


    @CallSuper
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val usedEvent = optionsMenuListener?.onOptionsItemSelected(item)
        if (usedEvent != null && usedEvent) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    @CallSuper
    override fun onPrepareOptionsMenu(menu: Menu) {
        optionsMenuListener?.onPrepareOptionsMenu(menu)
        super.onPrepareOptionsMenu(menu)
    }
}
