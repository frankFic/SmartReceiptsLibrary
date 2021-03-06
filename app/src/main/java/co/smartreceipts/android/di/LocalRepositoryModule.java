package co.smartreceipts.android.di;

import android.content.Context;

import co.smartreceipts.android.di.scopes.ApplicationScope;
import co.smartreceipts.android.model.ColumnDefinitions;
import co.smartreceipts.android.model.Receipt;
import co.smartreceipts.android.model.impl.columns.receipts.ReceiptColumnDefinitions;
import co.smartreceipts.android.persistence.DatabaseHelper;
import co.smartreceipts.android.persistence.database.defaults.TableDefaultsCustomizer;
import co.smartreceipts.android.persistence.database.tables.ordering.OrderingPreferencesManager;
import co.smartreceipts.android.settings.UserPreferenceManager;
import dagger.Module;
import dagger.Provides;
import wb.android.storage.StorageManager;

@Module
public class LocalRepositoryModule {

    @Provides
    @ApplicationScope
    public static StorageManager provideStorageManager(Context context) {
        return StorageManager.getInstance(context);
    }

    @Provides
    @ApplicationScope
    public static DatabaseHelper provideDatabaseHelper(Context context, StorageManager storageManager,
                                                       UserPreferenceManager preferences,
                                                       ReceiptColumnDefinitions receiptColumnDefinitions,
                                                       TableDefaultsCustomizer tableDefaultsCustomizer,
                                                       OrderingPreferencesManager orderingPreferencesManager) {
        return DatabaseHelper.getInstance(context, storageManager, preferences, receiptColumnDefinitions,
                tableDefaultsCustomizer, orderingPreferencesManager);
    }

    @Provides
    @ApplicationScope
    public static ColumnDefinitions<Receipt> provideColumnDefinitionReceipts(ReceiptColumnDefinitions receiptColumnDefinitions) {
        return receiptColumnDefinitions;
    }
}
