"""Add DocumentTransaction to DocumentStatus relationship

Revision ID: ee93ee59714c
Revises: 5ee3bb9a4b4d
Create Date: 2023-05-03 14:04:40.584682

"""
from alembic import op
import sqlalchemy as sa


# revision identifiers, used by Alembic.
revision = 'ee93ee59714c'
down_revision = '5ee3bb9a4b4d'
branch_labels = None
depends_on = None


def upgrade():
    # ### commands auto generated by Alembic - please adjust! ###
    op.add_column('document_transaction', sa.Column('status_id', sa.Integer(), nullable=True))
    op.create_foreign_key(None, 'document_transaction', 'document_status', ['status_id'], ['id'])
    # ### end Alembic commands ###


def downgrade():
    # ### commands auto generated by Alembic - please adjust! ###
    op.drop_constraint(None, 'document_transaction', type_='foreignkey')
    op.drop_column('document_transaction', 'status_id')
    # ### end Alembic commands ###