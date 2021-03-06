/*! ******************************************************************************
 *
 * Pentaho Data Integration
 *
 * Copyright (C) 2016 by Pentaho : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package org.pentaho.di.trans.steps.synchronizeaftermerge;

import org.junit.Before;
import org.junit.Test;
import org.pentaho.di.core.injection.BaseMetadataInjectionTest;

public class SynchronizeAfterMergeMetaInjectionTest extends BaseMetadataInjectionTest<SynchronizeAfterMergeMeta> {

  @Before
  public void setup() {
    super.setup( new SynchronizeAfterMergeMeta() );
  }

  @Test
  public void test() throws Exception {
    check( "SHEMA_NAME", new StringGetter() {
      @Override
      public String get() {
        return meta.getSchemaName();
      }
    } );
    check( "TABLE_NAME", new StringGetter() {
      @Override
      public String get() {
        return meta.getTableName();
      }
    } );
    check( "TABLE_FIELD", new StringGetter() {
      @Override
      public String get() {
        return meta.getKeyLookup()[0];
      }
    } );
    check( "STREAM_FIELD1", new StringGetter() {
      @Override
      public String get() {
        return meta.getKeyStream()[0];
      }
    } );
    check( "STREAM_FIELD2", new StringGetter() {
      @Override
      public String get() {
        return meta.getKeyStream2()[0];
      }
    } );
    check( "COMPARATOR", new StringGetter() {
      @Override
      public String get() {
        return meta.getKeyCondition()[0];
      }
    } );

    check( "UPDATE_TABLE_FIELD", new StringGetter() {
      @Override
      public String get() {
        return meta.getUpdateLookup()[0];
      }
    } );
    check( "STREAM_FIELD", new StringGetter() {
      @Override
      public String get() {
        return meta.getUpdateStream()[0];
      }
    } );
    check( "UPDATE", new BooleanGetter() {
      @Override
      public boolean get() {
        return meta.getUpdate()[0];
      }
    } );

    check( "COMMIT_SIZE", new IntGetter() {
      @Override
      public int get() {
        return meta.getCommitSize();
      }
    } );
    check( "TABLE_NAME_IN_FIELD", new BooleanGetter() {
      @Override
      public boolean get() {
        return meta.istablenameInField();
      }
    } );
    check( "TABLE_NAME_FIELD", new StringGetter() {
      @Override
      public String get() {
        return meta.gettablenameField();
      }
    } );
    check( "OPERATION_ORDER_FIELD", new StringGetter() {
      @Override
      public String get() {
        return meta.getOperationOrderField();
      }
    } );
    check( "USE_BATCH_UPDATE", new BooleanGetter() {
      @Override
      public boolean get() {
        return meta.useBatchUpdate();
      }
    } );
    check( "PERFORM_LOOKUP", new BooleanGetter() {
      @Override
      public boolean get() {
        return meta.isPerformLookup();
      }
    } );
    check( "ORDER_INSERT", new StringGetter() {
      @Override
      public String get() {
        return meta.getOrderInsert();
      }
    } );
    check( "ORDER_UPDATE", new StringGetter() {
      @Override
      public String get() {
        return meta.getOrderUpdate();
      }
    } );
    check( "ORDER_DELETE", new StringGetter() {
      @Override
      public String get() {
        return meta.getOrderDelete();
      }
    } );
    check( "CONNECTION_NAME", new StringGetter() {
      public String get() {
        return "My Connection";
      }
    }, "My Connection" );
  }
}
