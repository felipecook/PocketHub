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
package com.github.pockethub.android.ui.commit;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import com.meisolsson.githubsdk.model.Repository;
import com.github.pockethub.android.ui.base.FragmentStatePagerAdapter;

import static com.github.pockethub.android.Intents.EXTRA_BASE;
import static com.github.pockethub.android.Intents.EXTRA_REPOSITORY;

/**
 * Pager over commits
 */
public class CommitPagerAdapter extends FragmentStatePagerAdapter {

    private final Repository repository;

    private final CharSequence[] ids;

    /**
     * @param activity
     * @param repository
     * @param ids
     */
    public CommitPagerAdapter(AppCompatActivity activity,
            Repository repository, CharSequence[] ids) {
        super(activity);

        this.repository = repository;
        this.ids = ids;
    }

    @Override
    public Fragment getItem(final int position) {
        Bundle arguments = new Bundle();
        arguments.putString(EXTRA_BASE, ids[position].toString());
        arguments.putParcelable(EXTRA_REPOSITORY, repository);
        CommitDiffListFragment fragment = new CommitDiffListFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public int getCount() {
        return ids.length;
    }
}
